package nextgen.actions;

public class CopyInto extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel thisModel;
   private final nextgen.model.STModel other;

	public CopyInto(nextgen.model.STModel thisModel, nextgen.model.STModel other) {
		super("Copy from " + nextgen.utils.STModelUtil.getSTModelName(other, other.getUuid()));
		this.thisModel = thisModel;
		this.other = other;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.List<nextgen.model.STParameter> thisParameters = thisModel.getStTemplate().getParameters().collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STParameter> otherParameters = other.getStTemplate().getParameters().collect(java.util.stream.Collectors.toList());

      for (nextgen.model.STParameter otherParameter : otherParameters) {
         for (nextgen.model.STParameter thisParameter : thisParameters) {
            final boolean sameParameterType = thisParameter.getType().equals(otherParameter.getType());
            final boolean sameParameterName = thisParameter.getName().equals(otherParameter.getName());
            if (sameParameterType && sameParameterName) {
               switch (otherParameter.getType()) {
                  case SINGLE:
                     addSingleIfNotAlreadySet(otherParameter, thisParameter);
                     break;
                  case LIST:
                     addAllElementsNotAlreadyInList(otherParameter, thisParameter);
                     break;
                  case KVLIST:
                     addAllKVElementsNotAlreadyInList(otherParameter, thisParameter);
                     break;
               }
            }
         }
      }

      final java.util.List<nextgen.model.STFile> otherFiles = other.getFiles().collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STFile> thisFiles = thisModel.getFiles().collect(java.util.stream.Collectors.toList());

      if (thisFiles.isEmpty()) {
         for (nextgen.model.STFile otherFile : otherFiles) {
            final nextgen.model.STFile thisFile = appModel().db.newSTFile(otherFile);
            final String thisName = nextgen.utils.STModelUtil.getSTModelName(thisModel, null);
            if (thisName != null) thisFile.setName(appModel().db.newSTValue(thisName));
            thisModel.addFiles(thisFile);
            nextgen.events.NewFileSink.post(thisModel, thisFile);
         }
      }

      nextgen.events.STModelChanged.post(thisModel);
   }

   private void addSingleIfNotAlreadySet(nextgen.model.STParameter otherParameter, nextgen.model.STParameter thisParameter) {
      final java.util.Optional<nextgen.model.STArgument> otherSingle = other.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(otherParameter)).findFirst();
      final java.util.Optional<nextgen.model.STArgument> thisSingle = thisModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(thisParameter)).findFirst();

      if (otherSingle.isPresent() && !thisSingle.isPresent()) {
         final nextgen.model.STValue stValue = appModel().db.newSTValue(otherSingle.get().getValue());
         final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(thisParameter, stValue);
         thisModel.addArguments(stArgument);
         nextgen.events.NewSTArgument.post(stArgument, thisModel, thisParameter, stValue);
      }
   }

   private void addAllElementsNotAlreadyInList(nextgen.model.STParameter otherParameter, nextgen.model.STParameter thisParameter) {
      final java.util.List<nextgen.model.STArgument> otherList = other.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(otherParameter)).collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STArgument> thisList = thisModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(thisParameter)).collect(java.util.stream.Collectors.toList());

      for (nextgen.model.STArgument otherArgument : otherList) {
         if (thisList.stream().noneMatch(thisArgument -> thisArgument.getValue().equals(otherArgument.getValue()))) {
            final nextgen.model.STValue stValue = appModel().db.newSTValue(otherArgument.getValue());
            final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(thisParameter, stValue);
            thisModel.addArguments(stArgument);
            nextgen.events.NewSTArgument.post(stArgument, thisModel, thisParameter, stValue);
         }
      }
   }

   private void addAllKVElementsNotAlreadyInList(nextgen.model.STParameter otherParameter, nextgen.model.STParameter thisParameter) {

      final java.util.List<nextgen.model.STArgument> otherList = other.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(otherParameter)).collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STArgument> thisList = thisModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(thisParameter)).collect(java.util.stream.Collectors.toList());

      for (nextgen.model.STArgument otherArgument : otherList) {
         if (thisList.stream().noneMatch(thisArgument -> thisArgument.getValue().equals(otherArgument.getValue()))) {

            java.util.Collection<nextgen.model.STArgumentKV> thisKVs = new java.util.ArrayList<>();

            final java.util.List<nextgen.model.STParameterKey> otherKeys = otherParameter.getKeysSorted().collect(java.util.stream.Collectors.toList());
            final java.util.List<nextgen.model.STParameterKey> thisKeys = thisParameter.getKeysSorted().collect(java.util.stream.Collectors.toList());
            for (nextgen.model.STParameterKey otherKey : otherKeys) {
               for (nextgen.model.STParameterKey thisKey : thisKeys) {
                  final boolean sameKeyName = otherKey.getName().equals(thisKey.getName());
                  final boolean sameKeyType = otherKey.getArgumentType().equals(thisKey.getArgumentType());
                  if (sameKeyName && sameKeyType) {
                     final java.util.Optional<nextgen.model.STArgumentKV> otherArgumentKV = otherArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(otherKey)).findAny();
                     otherArgumentKV.ifPresent(stArgumentKV -> thisKVs.add(appModel().db.newSTArgumentKV().setStParameterKey(thisKey).setValue(appModel().db.newSTValue(stArgumentKV.getValue()))));
                  }
               }
            }

            if (!thisKVs.isEmpty()) {
               final nextgen.model.STArgument stArgument = appModel().db.newSTArgument().setStParameter(thisParameter);
               for (nextgen.model.STArgumentKV kv : thisKVs) stArgument.addKeyValues(kv);
               thisModel.addArguments(stArgument);
               nextgen.events.NewSTKVArgument.post(thisModel, thisParameter, stArgument, thisKVs);
            }
         }
      }
   }
}
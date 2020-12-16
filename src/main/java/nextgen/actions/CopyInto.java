package nextgen.actions;

public class CopyInto extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel thisModel;
   private final nextgen.model.STModel otherModel;

	public CopyInto(nextgen.model.STModel thisModel, nextgen.model.STModel otherModel) {
		super("Copy from " + nextgen.utils.STModelUtil.getSTModelName(otherModel, otherModel.getUuid()));
		this.thisModel = thisModel;
		this.otherModel = otherModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.List<nextgen.model.STParameter> thisParameters = thisModel.getStTemplate().getParametersSorted().collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STParameter> otherModelParameters = otherModel.getStTemplate().getParametersSorted().collect(java.util.stream.Collectors.toList());

      for (nextgen.model.STParameter otherModelParameter : otherModelParameters) {
         for (nextgen.model.STParameter thisParameter : thisParameters) {
            final boolean sameParameterType = thisParameter.getType().equals(otherModelParameter.getType());
            final boolean sameParameterName = thisParameter.getName().equals(otherModelParameter.getName());
            if (sameParameterType && sameParameterName) {
               switch (otherModelParameter.getType()) {
                  case SINGLE:
                     addSingleIfNotAlreadySet(otherModelParameter, thisParameter);
                     break;
                  case LIST:
                     addAllElementsNotAlreadyInList(otherModelParameter, thisParameter);
                     break;
                  case KVLIST:
                     addAllKVElementsNotAlreadyInList(otherModelParameter, thisParameter);
                     break;
               }
            }
         }
      }

      final java.util.List<nextgen.model.STFile> otherModelFiles = otherModel.getFiles().collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STFile> thisFiles = thisModel.getFiles().collect(java.util.stream.Collectors.toList());

      if (thisFiles.isEmpty()) {
         for (nextgen.model.STFile otherModelFile : otherModelFiles) {
            final nextgen.model.STFile thisFile = appModel().db.newSTFile(otherModelFile);
            final String thisName = nextgen.utils.STModelUtil.getSTModelName(thisModel, null);
            if (thisName != null) thisFile.setName(appModel().db.newSTValue(thisName));
            thisModel.addFiles(thisFile);
            nextgen.events.NewFileSink.post(thisModel, thisFile);
         }
      }

      nextgen.events.STModelChanged.post(thisModel);
   }

   private void addSingleIfNotAlreadySet(nextgen.model.STParameter otherModelParameter, nextgen.model.STParameter thisParameter) {
      final java.util.Optional<nextgen.model.STArgument> otherModelSingle = otherModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(otherModelParameter)).findFirst();
      final java.util.Optional<nextgen.model.STArgument> thisSingle = thisModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(thisParameter)).findFirst();

      if (otherModelSingle.isPresent() && !thisSingle.isPresent()) {
         final nextgen.model.STValue stValue = appModel().db.newSTValue(otherModelSingle.get().getValue());
         final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(thisParameter, stValue);
         thisModel.addArguments(stArgument);
         nextgen.events.NewSTArgument.post(stArgument, thisModel, thisParameter, stValue);
      }
   }

   private void addAllElementsNotAlreadyInList(nextgen.model.STParameter otherModelParameter, nextgen.model.STParameter thisParameter) {
      final java.util.List<nextgen.model.STArgument> otherModelList = otherModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(otherModelParameter)).collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STArgument> thisList = thisModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(thisParameter)).collect(java.util.stream.Collectors.toList());

      for (nextgen.model.STArgument otherModelArgument : otherModelList) {
         if (thisList.stream().noneMatch(thisArgument -> thisArgument.getValue().equals(otherModelArgument.getValue()))) {
            final nextgen.model.STValue stValue = appModel().db.newSTValue(otherModelArgument.getValue());
            final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(thisParameter, stValue);
            thisModel.addArguments(stArgument);
            nextgen.events.NewSTArgument.post(stArgument, thisModel, thisParameter, stValue);
         }
      }
   }

   private void addAllKVElementsNotAlreadyInList(nextgen.model.STParameter otherModelParameter, nextgen.model.STParameter thisParameter) {

      final java.util.List<nextgen.model.STArgument> otherModelList = otherModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(otherModelParameter)).collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STArgument> thisList = thisModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(thisParameter)).collect(java.util.stream.Collectors.toList());

      for (nextgen.model.STArgument otherModelArgument : otherModelList) {
         if (thisList.stream().noneMatch(thisArgument -> thisArgument.getValue().equals(otherModelArgument.getValue()))) {

            java.util.Collection<nextgen.model.STArgumentKV> thisKVs = new java.util.ArrayList<>();

            final java.util.List<nextgen.model.STParameterKey> otherModelKeys = otherModelParameter.getKeysSorted().collect(java.util.stream.Collectors.toList());
            final java.util.List<nextgen.model.STParameterKey> thisKeys = thisParameter.getKeysSorted().collect(java.util.stream.Collectors.toList());
            for (nextgen.model.STParameterKey otherModelKey : otherModelKeys) {
               for (nextgen.model.STParameterKey thisKey : thisKeys) {
                  final boolean sameKeyName = otherModelKey.getName().equals(thisKey.getName());
                  final boolean sameKeyType = otherModelKey.getArgumentType().equals(thisKey.getArgumentType());
                  if (sameKeyName && sameKeyType) {
                     final java.util.Optional<nextgen.model.STArgumentKV> otherModelArgumentKV = otherModelArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(otherModelKey)).findAny();
                     otherModelArgumentKV.ifPresent(stArgumentKV -> thisKVs.add(appModel().db.newSTArgumentKV().setStParameterKey(thisKey).setValue(appModel().db.newSTValue(stArgumentKV.getValue()))));
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
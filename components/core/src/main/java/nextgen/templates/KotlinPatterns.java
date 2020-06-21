package nextgen.templates;

import nextgen.templates.kotlin.Expression;
import nextgen.templates.kotlin.FieldDeclaration;
import nextgen.templates.kotlin.KotlinST;

public class KotlinPatterns extends KotlinST {

   public static Expression asThisExpression(FieldDeclaration fieldDeclaration) {
      return newThisExpression().setExpression(newVarExpression().setVarname(fieldDeclaration.getName()));
   }

   public static Expression asScopeExpression(String scope, FieldDeclaration fieldDeclaration) {
      return newScopeExpression().setScope(scope).setExpression(newVarExpression().setVarname(fieldDeclaration.getName()));
   }

}

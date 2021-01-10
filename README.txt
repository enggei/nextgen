A different type of texteditor for developers.


Domain
    name            1   String
    entities        *   DomainEntity
    relations       *   DomainRelation

    DomainEntity
        name            1   String

    DomainRelation
        name            1   String
        value           1   STValue
        src             1   DomainEntity
        dst             1   DomainEntity
        type            1   DomainRelationType

        DomainRelationType
            ONE
            MANY
            OPTIONAL

STProject
	name		    1	String
	root		    1	String
	models			*	STModel
	values			*	STValue


STGroup
	name			1	String
	files			*	STGroupFile
	templates		*	STTemplate
	interfaces	    *	STInterface
	enums			*	STEnum
	actions         *	STAction

	STGroupFile
		packageName     1	STValue
		path			1	STValue

	STTemplate
		name			1	String
		text			1	String
		implements		*	String			// change to STInterface
		parameter		*	STParameter
		children		*	STTemplate

	STInterface
		name			1	String

	STEnum
		name			1	String
		values			*	STEnumValue

	STAction
		name			1	String
		statements		*	String
		imports			*	String
		methods			*	String

		STValue
			type			1	STValueType
			value			?	String			type=PRIMITIVE
			stModel			?	STModel			type=STMODEL
			stEnum			?	STEnumValue		type=ENUM

		STParameter
			name			1	String
			type			1	STParameterType
			keys			*	STParameterKey
			argumentType	1	String

		STEnumValue
			name			1	String
			lexical			1	String

			STValueType
				STMODEL
				PRIMITIVE
				ENUM

			STModel
				stTemplate	    1	STTemplate
				files		    *	STFile
				arguments	    *	STArgument
					
			STParameterType
				SINGLE			
				LIST
				KVLIST

			STParameterKey
				name			1	String
				argumentType	1	String	// change to STInterface
								
				STFile
					type		    1	STValue
					packageName	    1	STValue
					path		    1	STValue
					
				STArgument
					stParameter	    1	STParameter
					value			1	STValue
					keyValues	    *	STArgumentKV
					
					STArgumentKV
						stParameterKey  1	STParameterKey
						value			1	STValue






The constraints of word order and dependency, derived from natural language,
blossom into four abstract computer language patterns.
• Sequence: This is a sequence of elements such as the values in an array
initializer.
• Choice: This is a choice between multiple, alternative phrases such as
the different kinds of statements in a programming language.
• Token dependence: The presence of one token requires the presence of
its counterpart elsewhere in a phrase such as matching left and right
parentheses.
• Nested phrase: This is a self-similar language construct such as nested
arithmetic expressions or nested statement blocks in a programming
language.
To implement these patterns, we really only need grammar rules comprised
of alternatives, token references, and rule references (Backus-Naur-Format
[BNF]). For convenience, though, we’ll also group those elements into subrules.
Subrules are just in-lined rules wrapped in parentheses. We can mark
subrules as optional ( ? ) and as zero-or-more ( * ) or one-or-more ( + ) loops to
recognize the enclosed grammar fragments multiple times (Extended Backus-
Naur-Format [EBNF]).
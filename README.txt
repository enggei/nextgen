A different type of texteditor for developers.

Domain:


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

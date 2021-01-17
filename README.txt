A different type of texteditor for developers.

Domain
    name            1   String
    entities        *   DomainEntity
    relations       *   DomainRelation

    DomainEntity
        name            1   String
        type            1   DomainEntityType

    DomainRelation
        name            1   String
        src             1   DomainEntity
        dst             1   DomainEntity
        type            1   DomainRelationType

        DomainEntityType
            ENUM
            ENTITY

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

Causal sets always posses some symmetry, a key point, as it means that causality and
symmetry go together, where there is causality there is also symmetry. Hence, symmetry is
present in all systems. But this is not the same as geometric symmetry used in neuroscience. Let
us call it causal symmetry. The principle of symmetry is the second fundamental principle of
nature. It says that any system that has symmetry also has an invariant quantity. An invariant
quantity is something that is certain and is conserved, something that we can observe and
understand and measure. The principle of symmetry and the fact that causality is found
everywhere tells us that invariants also exist everywhere, and in very large numbers. This theory
predicts the existence of millions of recognizable signals and structures in the brain. Much of the
effort that follows is directed towards the analysis of these invariants and their quantitative
calculation directly from the causal set. No other known theory of Physics can achieve this, which
is why the causal theory is proposed as necessary for complex systems like the brain that work
across many substrates.
The principle of least-action is the third fundamental principle of nature. It says that the
dynamics of a conservative dynamical system converges towards an invariant behavior,
sometimes called an attractor. This principle tells us exactly how our invariants are to be
calculated: we need to minimize the action first. A system becomes conservative when the action
in the system is minimized. In causal logic this says that the causal symmetry of a causal set – the
collection of different total orders that represent the causal set S will converge to an invariant
behavior when the causal action is minimized.

creation patterns

new Object()
new Object(Object ... params)



stream()        sequence
filter(f)       predicates/choice
map()           transform
forEach(c)      apply


stream().filter(f)


// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PCFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, OP1=14, OP2=15, OP=16, LIT=17, 
		LINE_COMMENT=18, WS=19, VAR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "OP1", "OP2", "OP", "LIT", "LINE_COMMENT", 
			"WS", "VAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'ifz'", "'then'", "'else'", "'let'", "'='", "'and'", 
			"'in'", "'fun'", "'->'", "'fix'", "'fixfun'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "OP1", "OP2", "OP", "LIT", "LINE_COMMENT", "WS", "VAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PCFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PCF.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0014\u008b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f"+
		"a\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010f\b\u0010\n\u0010"+
		"\f\u0010i\t\u0010\u0003\u0010k\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011q\b\u0011\n\u0011\f\u0011t\t\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012{\b\u0012"+
		"\u000b\u0012\f\u0012|\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013"+
		"\u0082\b\u0013\u000b\u0013\f\u0013\u0083\u0001\u0013\u0005\u0013\u0087"+
		"\b\u0013\n\u0013\f\u0013\u008a\t\u0013\u0000\u0000\u0014\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\b\u0002\u0000**//\u0002\u0000"+
		"++--\u0001\u000019\u0001\u000009\u0001\u0000\n\n\u0003\u0000\t\n\r\r "+
		" \u0003\u0000AZ__az\u0004\u000009AZ__az\u0091\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003+\u0001\u0000\u0000"+
		"\u0000\u0005-\u0001\u0000\u0000\u0000\u00071\u0001\u0000\u0000\u0000\t"+
		"6\u0001\u0000\u0000\u0000\u000b;\u0001\u0000\u0000\u0000\r?\u0001\u0000"+
		"\u0000\u0000\u000fA\u0001\u0000\u0000\u0000\u0011E\u0001\u0000\u0000\u0000"+
		"\u0013H\u0001\u0000\u0000\u0000\u0015L\u0001\u0000\u0000\u0000\u0017O"+
		"\u0001\u0000\u0000\u0000\u0019S\u0001\u0000\u0000\u0000\u001bZ\u0001\u0000"+
		"\u0000\u0000\u001d\\\u0001\u0000\u0000\u0000\u001f`\u0001\u0000\u0000"+
		"\u0000!j\u0001\u0000\u0000\u0000#l\u0001\u0000\u0000\u0000%z\u0001\u0000"+
		"\u0000\u0000\'\u0081\u0001\u0000\u0000\u0000)*\u0005(\u0000\u0000*\u0002"+
		"\u0001\u0000\u0000\u0000+,\u0005)\u0000\u0000,\u0004\u0001\u0000\u0000"+
		"\u0000-.\u0005i\u0000\u0000./\u0005f\u0000\u0000/0\u0005z\u0000\u0000"+
		"0\u0006\u0001\u0000\u0000\u000012\u0005t\u0000\u000023\u0005h\u0000\u0000"+
		"34\u0005e\u0000\u000045\u0005n\u0000\u00005\b\u0001\u0000\u0000\u0000"+
		"67\u0005e\u0000\u000078\u0005l\u0000\u000089\u0005s\u0000\u00009:\u0005"+
		"e\u0000\u0000:\n\u0001\u0000\u0000\u0000;<\u0005l\u0000\u0000<=\u0005"+
		"e\u0000\u0000=>\u0005t\u0000\u0000>\f\u0001\u0000\u0000\u0000?@\u0005"+
		"=\u0000\u0000@\u000e\u0001\u0000\u0000\u0000AB\u0005a\u0000\u0000BC\u0005"+
		"n\u0000\u0000CD\u0005d\u0000\u0000D\u0010\u0001\u0000\u0000\u0000EF\u0005"+
		"i\u0000\u0000FG\u0005n\u0000\u0000G\u0012\u0001\u0000\u0000\u0000HI\u0005"+
		"f\u0000\u0000IJ\u0005u\u0000\u0000JK\u0005n\u0000\u0000K\u0014\u0001\u0000"+
		"\u0000\u0000LM\u0005-\u0000\u0000MN\u0005>\u0000\u0000N\u0016\u0001\u0000"+
		"\u0000\u0000OP\u0005f\u0000\u0000PQ\u0005i\u0000\u0000QR\u0005x\u0000"+
		"\u0000R\u0018\u0001\u0000\u0000\u0000ST\u0005f\u0000\u0000TU\u0005i\u0000"+
		"\u0000UV\u0005x\u0000\u0000VW\u0005f\u0000\u0000WX\u0005u\u0000\u0000"+
		"XY\u0005n\u0000\u0000Y\u001a\u0001\u0000\u0000\u0000Z[\u0007\u0000\u0000"+
		"\u0000[\u001c\u0001\u0000\u0000\u0000\\]\u0007\u0001\u0000\u0000]\u001e"+
		"\u0001\u0000\u0000\u0000^a\u0003\u001b\r\u0000_a\u0003\u001d\u000e\u0000"+
		"`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000a \u0001\u0000\u0000"+
		"\u0000bk\u00050\u0000\u0000cg\u0007\u0002\u0000\u0000df\u0007\u0003\u0000"+
		"\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000jb\u0001\u0000\u0000\u0000jc\u0001\u0000\u0000\u0000"+
		"k\"\u0001\u0000\u0000\u0000lm\u0005/\u0000\u0000mn\u0005/\u0000\u0000"+
		"nr\u0001\u0000\u0000\u0000oq\b\u0004\u0000\u0000po\u0001\u0000\u0000\u0000"+
		"qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000su\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005\n\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wx\u0006\u0011\u0000\u0000x$\u0001\u0000"+
		"\u0000\u0000y{\u0007\u0005\u0000\u0000zy\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u007f\u0006\u0012\u0000\u0000\u007f&\u0001"+
		"\u0000\u0000\u0000\u0080\u0082\u0007\u0006\u0000\u0000\u0081\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0088\u0001"+
		"\u0000\u0000\u0000\u0085\u0087\u0007\u0007\u0000\u0000\u0086\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089(\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\b\u0000`gjr|\u0083\u0088"+
		"\u0001\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
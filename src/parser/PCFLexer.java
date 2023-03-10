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
		T__9=10, T__10=11, T__11=12, OP1=13, OP2=14, OP=15, LIT=16, LINE_COMMENT=17, 
		WS=18, VAR=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "OP1", "OP2", "OP", "LIT", "LINE_COMMENT", 
			"WS", "VAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'ifz'", "'then'", "'else'", "'let'", "'='", "'and'", 
			"'in'", "'fun'", "'->'", "'fix'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "OP1", "OP2", "OP", "LIT", "LINE_COMMENT", "WS", "VAR"
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
		"\u0004\u0000\u0013\u0082\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000eX\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f]\b\u000f\n\u000f\f\u000f`\t"+
		"\u000f\u0003\u000fb\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010h\b\u0010\n\u0010\f\u0010k\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011r\b\u0011\u000b"+
		"\u0011\f\u0011s\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012y\b\u0012"+
		"\u000b\u0012\f\u0012z\u0001\u0012\u0005\u0012~\b\u0012\n\u0012\f\u0012"+
		"\u0081\t\u0012\u0000\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\u0001\u0000\b\u0002\u0000**//\u0002\u0000++--\u0001\u000019\u0001\u0000"+
		"09\u0001\u0000\n\n\u0003\u0000\t\n\r\r  \u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0088\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003)\u0001"+
		"\u0000\u0000\u0000\u0005+\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000"+
		"\u0000\t4\u0001\u0000\u0000\u0000\u000b9\u0001\u0000\u0000\u0000\r=\u0001"+
		"\u0000\u0000\u0000\u000f?\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000"+
		"\u0000\u0013F\u0001\u0000\u0000\u0000\u0015J\u0001\u0000\u0000\u0000\u0017"+
		"M\u0001\u0000\u0000\u0000\u0019Q\u0001\u0000\u0000\u0000\u001bS\u0001"+
		"\u0000\u0000\u0000\u001dW\u0001\u0000\u0000\u0000\u001fa\u0001\u0000\u0000"+
		"\u0000!c\u0001\u0000\u0000\u0000#q\u0001\u0000\u0000\u0000%x\u0001\u0000"+
		"\u0000\u0000\'(\u0005(\u0000\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005"+
		")\u0000\u0000*\u0004\u0001\u0000\u0000\u0000+,\u0005i\u0000\u0000,-\u0005"+
		"f\u0000\u0000-.\u0005z\u0000\u0000.\u0006\u0001\u0000\u0000\u0000/0\u0005"+
		"t\u0000\u000001\u0005h\u0000\u000012\u0005e\u0000\u000023\u0005n\u0000"+
		"\u00003\b\u0001\u0000\u0000\u000045\u0005e\u0000\u000056\u0005l\u0000"+
		"\u000067\u0005s\u0000\u000078\u0005e\u0000\u00008\n\u0001\u0000\u0000"+
		"\u00009:\u0005l\u0000\u0000:;\u0005e\u0000\u0000;<\u0005t\u0000\u0000"+
		"<\f\u0001\u0000\u0000\u0000=>\u0005=\u0000\u0000>\u000e\u0001\u0000\u0000"+
		"\u0000?@\u0005a\u0000\u0000@A\u0005n\u0000\u0000AB\u0005d\u0000\u0000"+
		"B\u0010\u0001\u0000\u0000\u0000CD\u0005i\u0000\u0000DE\u0005n\u0000\u0000"+
		"E\u0012\u0001\u0000\u0000\u0000FG\u0005f\u0000\u0000GH\u0005u\u0000\u0000"+
		"HI\u0005n\u0000\u0000I\u0014\u0001\u0000\u0000\u0000JK\u0005-\u0000\u0000"+
		"KL\u0005>\u0000\u0000L\u0016\u0001\u0000\u0000\u0000MN\u0005f\u0000\u0000"+
		"NO\u0005i\u0000\u0000OP\u0005x\u0000\u0000P\u0018\u0001\u0000\u0000\u0000"+
		"QR\u0007\u0000\u0000\u0000R\u001a\u0001\u0000\u0000\u0000ST\u0007\u0001"+
		"\u0000\u0000T\u001c\u0001\u0000\u0000\u0000UX\u0003\u0019\f\u0000VX\u0003"+
		"\u001b\r\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X\u001e"+
		"\u0001\u0000\u0000\u0000Yb\u00050\u0000\u0000Z^\u0007\u0002\u0000\u0000"+
		"[]\u0007\u0003\u0000\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_b\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000aY\u0001\u0000\u0000\u0000aZ\u0001"+
		"\u0000\u0000\u0000b \u0001\u0000\u0000\u0000cd\u0005/\u0000\u0000de\u0005"+
		"/\u0000\u0000ei\u0001\u0000\u0000\u0000fh\b\u0004\u0000\u0000gf\u0001"+
		"\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000lm\u0005\n\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0006\u0010\u0000"+
		"\u0000o\"\u0001\u0000\u0000\u0000pr\u0007\u0005\u0000\u0000qp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0006\u0011\u0000\u0000"+
		"v$\u0001\u0000\u0000\u0000wy\u0007\u0006\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{\u007f\u0001\u0000\u0000\u0000|~\u0007\u0007\u0000\u0000"+
		"}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080&\u0001\u0000"+
		"\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\b\u0000W^aisz\u007f\u0001"+
		"\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
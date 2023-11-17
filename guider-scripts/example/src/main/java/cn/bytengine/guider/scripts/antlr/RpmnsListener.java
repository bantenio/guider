// Generated from grammar/Rpmns.g4 by ANTLR 4.13.1
 package cn.bytengine.guider.scripts.antlr; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RpmnsParser}.
 */
public interface RpmnsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RpmnsParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(RpmnsParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link RpmnsParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(RpmnsParser.SContext ctx);
}
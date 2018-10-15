import ast.*;
/**
 * @author rdyer
 */
public abstract class AbstractNode {
	public abstract <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg);
}

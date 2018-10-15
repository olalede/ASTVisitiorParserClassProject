import ast.*;

public class Factor extends AbstractNode 
{
    public ParenthesisFactor pfNode  = new ParenthesisFactor();

    public void setParenthesisFactor(ParenthesisFactor pf)
    {
        pfNode = pf;
    }
    
    public ParenthesisFactor getParenthesisFactor()
    {
        return pfNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}
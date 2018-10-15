import ast.*;

public class Expression extends AbstractNode 
{
    public Term tNode = new Term();

    public void setTerm(Term t)
    {
        tNode = t;
    }
    
    public Term getTerm()
    {
        return tNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}
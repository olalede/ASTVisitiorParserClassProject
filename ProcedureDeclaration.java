import ast.*;

public class ProcedureDeclaration extends AbstractNode 
{
    public FormalParameters fpNode = new FormalParameters();
    public Block bNode = new Block();

    public void setFormalParemeters(FormalParameters fp)
    {
        fpNode = fp;
    }
    
    public FormalParameters getFormalParemeters()
    {
        return fpNode;
    }

    public void setBlock(Block b)
    {
        bNode = b;
    }
    
    public Block getBlock()
    {
        return bNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}
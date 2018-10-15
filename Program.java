import ast.*;


public class Program extends AbstractNode 
{

    public Block bNode = new Block();

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




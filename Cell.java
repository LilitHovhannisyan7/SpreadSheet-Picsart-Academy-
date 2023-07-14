 class ValueIsNotANumberException extends RuntimeException
 {
     public ValueIsNotANumberException(String message)
     {
         System.out.println(message);
     }
}
class ValueIsNullException extends RuntimeException
{
    public ValueIsNullException(String message)
    {
        System.out.println(message);
    }
}

class Cell
{

        private Object value;
        private Color color = Color.WHITE;
        private Type type = Type.NUMBER;

        public void setValue(Object value)
        {
            this.value = value;
        }
        public Object getValue()
        {
            return this.value;
        }
        public Type getType()

        {
            return this.type;
        }
        public void setColor(Color color)
        {
            this.color = color;
        }
        public Color getColor()
        {
            return this.color;
        }
        public void reset()
        {
            this.value = null;
            this.color = null;
        }


    public int toInt()
    {

            if (this.value instanceof Integer)
            {
                this.type = Type.NUMBER;
                int temp = (Integer) this.value;
                return temp;
            } else
            {
                throw new ValueIsNotANumberException("Value is not a Number.");
            }



    }

    public double toDouble()
    {

            if (this.value instanceof Number)
            {
                this.type = Type.NUMBER;
                return ((Number) this.value).doubleValue();
            }
            else
            {
                throw new ValueIsNotANumberException("Value is not a Number.");
            }


    }
}


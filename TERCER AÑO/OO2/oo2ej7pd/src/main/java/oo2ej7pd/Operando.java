package oo2ej7pd;

public abstract class Operando implements StateCalculadora{
        @Override
        public void mas(Calculadora c) {
            c.setEstado(new Error());
        }
        
        @Override
        public void menos(Calculadora c) {
            c.setEstado(new Error());
        }
        
        @Override
        public void por(Calculadora c) {
            c.setEstado(new Error());
        }
        
        @Override
        public void dividido(Calculadora c) {
            c.setEstado(new Error());
        }
        
        @Override
        public abstract void setValor(double unValor, Calculadora c);
        

        @Override
        public String getResultado(Calculadora c) {
            c.setEstado(new Error());
            //return c.getResultado();
            return "Error";
        }
}


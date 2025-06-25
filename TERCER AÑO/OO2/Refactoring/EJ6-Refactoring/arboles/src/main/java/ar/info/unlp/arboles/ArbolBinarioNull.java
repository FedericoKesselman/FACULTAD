package ar.info.unlp.arboles;

public class ArbolBinarioNull implements InterfazArbolBinario{

    public ArbolBinarioNull() {}
    
	@Override
	public int getValor() {
		return 0;
	}
	
	@Override
	public void setValor(int valor) { }
	
	@Override
	public InterfazArbolBinario getHijoIzquierdo() {
		return null;
	}
	
	@Override
	public void setHijoIzquierdo(InterfazArbolBinario hijoIzquierdo) { }
	
	@Override
	public InterfazArbolBinario getHijoDerecho() {
		return null;
	}
	
	@Override
	public void setDerecha(InterfazArbolBinario hijoDerecho) {}
	
	@Override
	public String recorrerPreorden() {
		return "";
	}
	
	@Override
	public String recorrerInorden() {
		return "";
	}
	@Override
	public String recorrerPostorden() {
		return "";
	}
}

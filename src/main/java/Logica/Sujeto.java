package Logica;

public interface Sujeto {
	public void notificar();
	public void registrarObservadores(Observer observer);
	public void eliminarObservadores(Observer observer);
}

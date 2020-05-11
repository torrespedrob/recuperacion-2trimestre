package Ex16ptb4b;

import java.util.HashMap;
import java.util.Set;

public class ListadoComerciales {
  //Crea el HashMap donde mapea a los comerciales
	private HashMap<String, Comercial> mapa = new HashMap<>();
	
	public void put(Comercial comercial) {
		String correo = comercial.getCorreo();
		mapa.put(correo, comercial);
	}
	
	public Comercial get(String correo) {
		return mapa.get(correo);
	}
	
	public void del(String correo) {
		mapa.remove(correo);
	}

	public Set<String> correos(){
		return mapa.keySet();
	}
}

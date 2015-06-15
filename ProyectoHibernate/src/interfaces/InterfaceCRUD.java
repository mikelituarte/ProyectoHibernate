package interfaces;

public interface InterfaceCRUD {

	Object insertar(Object objeto);
	Object actualizar(Object objeto);
	Object borrar(Object objeto);
	Object leer(Class clase, Object id);
}

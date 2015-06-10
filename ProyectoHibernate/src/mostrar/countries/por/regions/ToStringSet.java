package mostrar.countries.por.regions;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import tablas_Clases.Countries;
import tablas_Clases.Regions;

/*import org.hibernate.cfg.Mappings;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Set; */


public class ToStringSet implements Set{

	private Set s;
	
	public ToStringSet(Set s){
		this.s = s;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res = "";
		
		Iterator<Countries> it = s.iterator();
		Countries pais = null;
		while (it.hasNext()){
			pais = it.next();
			res = res + "---> "+pais.getCountryName() + " \n";
		}
		
		return res;
	}

	@Override
	public Stream parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeIf(Predicate arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Stream stream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEach(Consumer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Spliterator spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

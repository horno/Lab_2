import java.util.*;

public abstract class Task{
    // ------- TAREA 1 -------
    public static List<Integer> withinRange(List<Integer> l, int min, int max){
        Integer num;
        Iterator<Integer> it = l.iterator();
        ArrayList al = new ArrayList();
            while (it.hasNext()) {
                num = it.next();
                if (num != null && min <= num && num < max) {
                    al.add(num);
                }
            }
        return al;
    }
    // ------- TAREA 2 -------

    public static <E extends Comparable<? super E>> List<E> withinRange(List<E> l,E min, E max){
        E obj;
        Iterator<E> it = l.iterator();
        ArrayList al = new ArrayList();
        while(it.hasNext()){
            obj = it.next();
            if(obj != null && obj.compareTo(min) >= 0 &&  obj.compareTo(max) < 0){
                al.add(obj);
            }
        }
        return al;
    }
    public static <E> List<E> withinRange(Comparator<E> comp,List<E> l, E min, E max){
        E obj;
        Iterator<E> it = l.iterator();
        ArrayList al = new ArrayList();
        while(it.hasNext()){
            obj = it.next();
            if(obj != null && comp.compare(obj,min) >= 0 &&  comp.compare(obj,max) < 0){
                al.add(obj);
            }
        }
        return al;
    }
    // ------- TAREA 3 -------
    public static <E extends Comparable<? super E>> void copyWithRange(List<? super E> trg, List<? extends E> src, E min, E max){
        E obj;
        Iterator<? extends E> it = src.iterator();
        while (it.hasNext()){
            obj = it.next();
            if(obj != null && obj.compareTo(min) >= 0 && obj.compareTo(max) < 0){
                trg.add(obj);
            }
        }
    }
    public static <E> void copyWithRange(Comparator<E> comp,List<? super E> trg, List<? extends E> src, E min, E max){
        E obj;
        Iterator<? extends E> it = src.iterator();
        while(it.hasNext()){
            obj = it.next();
            if(obj != null && comp.compare(obj,min) >= 0 &&  comp.compare(obj,max) < 0){
                trg.add(obj);
            }
        }
    }
}

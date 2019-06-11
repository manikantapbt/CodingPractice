
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ClazzA extends Thread {
	static Integer a = 10;

	public static void main(String[] args) throws InterruptedException {

		Map<Integer,Integer> map = new HashMap<>();

		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);

		//map.forEach((k,v)->map.put(k, v*2));

		BiConsumer<Integer, Integer> consumer = new BiCon(map);
		//map.forEach(consumer);
		BiFunction<Integer, Integer,Integer> biFun= new BiFun();
		System.out.println(map.keySet().stream().map(x->biFun.apply(x, map.get(x))).collect(Collectors.toList()));
		System.out.println(map.keySet().stream().map(x->
				x+map.get(x)
		).collect(Collectors.toList()));

		System.out.println(map);
//		Thread t = new Thread(() -> foo1());
//
//		Thread t1 = new Thread(new Runnable() {
//			public void run() {
//				foo();
//			}
//		});
//		t.start();
//		t1.start();
//		t.join();
//		t1.join();
//		System.out.println("main Thread " + a);


	}

	private static void foo() {
		a = a + 10;
	}

	private static void foo1() {
		a = a + 5;
	}

	public void run() {

	}
}

class BiCon implements BiConsumer<Integer, Integer>{

	Map <Integer, Integer> map;

	BiCon(Map<Integer, Integer> map){
		this.map = map;
	}

	public void nonStaticMethod(){
		List<String> s = Arrays.asList("abc","def");

		//.filter(x-> x.startsWith("d")).forEach(Clazz::s);
	}

	@Override
	public void accept(Integer t, Integer u) {
		map.put(t, u + u);
	}
}

class BiFun implements BiFunction<Integer, Integer, Integer>{

	@Override
	public Integer apply(Integer t, Integer u) {
		return t+u;
	}

}

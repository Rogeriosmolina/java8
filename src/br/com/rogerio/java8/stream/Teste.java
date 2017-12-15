package br.com.rogerio.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Teste {
	
	
	public static void main(String[] args) {
		Teste.creation();
		Teste.streamOperations();
		Teste.streamOperationIterationg();
		Teste.streamOperationFiltering();
		
	}
	
	private static void creation() {
		// Um metodo padrão de Stream() é adicionado à interface Collection e permite a criação de um : Stream<T> usando qualquer coleção como fonte de elemento:
		List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
		Stream<String> streamList = list.stream();
		streamList.forEach(s -> System.out.print(s));
		System.out.println();
		
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamArray = Arrays.stream(arr);
		streamArray.forEach(s ->System.out.print(s));
		System.out.println();
		
		streamArray = Stream.of("a", "b", "c");
		streamArray.forEach(s ->System.out.print(s));
		
		/* Result:  
		  	abc
			abc
			abc
		 */
	}
	
	private static void streamOperations() {
		List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "a", "b"));
		long count = list.stream().distinct().count();
		System.out.println("Lista " + list.toString());
		System.out.println("Distinct Count:" + count);
		
		/* Result :
		  	Lista [a, b, c, a, b]
			Distinct Count:3
		 */
	}
	
	private static void streamOperationIterationg() {
		List<String> list = new ArrayList<String>(Arrays.asList("abacate", "banana", "caqui", "amora", "beterraba"));
		for (String string : list) {
		    if (string.contains("c")) {
		        System.out.println(string + " contem c");
		    }
		}
		System.out.println();
		
		boolean b = list.stream().anyMatch(element -> element.contains("c"));
		System.out.println("Existe a letra c na lista :" + list.toString() + "  = " + b);
		
		list.stream()
			.filter(element -> element.contains("c"))
			.forEach(System.out::print);
		
		System.out.println();
		List list1 = list.stream()
		    .filter(element -> element.contains("c"))
		    .collect(Collectors.toList());
		System.out.println(list1.toString());
	}
	
	private static void streamOperationFiltering() {
		/*
		 * O método filter () nos permite escolher um fluxo de elementos que satisfaçam um predicado
		 */
		ArrayList<String> list = new ArrayList<>();
		list.add("One");
		list.add("OneAndOnly");
		list.add("Derek");
		list.add("Change");
		list.add("factory");
		list.add("justBefore");
		list.add("Italy");
		list.add("Italy");
		list.add("Thursday");
		list.add("");
		list.add("");
		
		Stream<String> stream = list.stream()
				.filter(element -> element.contains("d"));
		
		stream.forEach(System.out :: println);
		
		/* Result:
		  	OneAndOnly
			Thursday
		 */
				
				
						
	}


}

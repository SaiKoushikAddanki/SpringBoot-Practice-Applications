package com.revision.demo.java8.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.revision.demo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamRealWorldProblems {

	public static void main(String[] args) {
		log.info("Start of the practice method!!");
		List<Employee> listOfEmp = generateEmpData();
		log.info("size of the total employe details are: {}", listOfEmp.size());

		Map<String, Long> result1 = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		for (Map.Entry e : result1.entrySet()) {
			log.info("count of the Employes with gender {} is {}", e.getKey(), e.getValue());
		}

		listOfEmp.stream().map(a -> a.getDepartment()).distinct().forEach(System.out::println);

		Map<String, Double> result2 = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));

		for (Map.Entry e : result2.entrySet()) {
			log.info("Average age of the Employes with gender {} is {}", e.getKey(), e.getValue());
		}

		Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
		Employee emp1 = listOfEmp.stream().sorted(comparator.reversed()).findFirst()
				.orElseThrow(() -> new NullPointerException());
		log.info("Details of the highest paid employee is: {}", emp1.toString());
		Employee emp2 = listOfEmp.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))
				.orElseThrow(NullPointerException::new);
		log.info("Details of the highest paid employee using maxBy is {}", emp2.toString());

		log.info("Names of Emp joined after 2015");
		Predicate<Employee> predicate1 = a -> a.getYearOfJoining() > 2015;
		listOfEmp.stream().filter(predicate1).map(Employee::getName).forEach(System.out::println);

		Map<String, Long> result3 = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		for (Map.Entry e : result3.entrySet()) {
			log.info("count of the Employes in department {} is {}", e.getKey(), e.getValue());
		}

		Map<String, Double> result4 = listOfEmp.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		for (Map.Entry e : result4.entrySet()) {
			log.info("Average sal of department {} is: {} ", e.getKey(), e.getValue());
		}

		Predicate<Employee> predicate2 = a -> a.getDepartment().equalsIgnoreCase("Product Development");
		Predicate<Employee> predicate3 = a -> a.getGender().equalsIgnoreCase("Male");
		Employee youngest = listOfEmp.stream().filter(predicate2.and(predicate3))
				.min(Comparator.comparing(Employee::getAge)).get();
		log.info("Youngest of the Product Development department is: {}", youngest.toString());
		Employee mostExperienced = listOfEmp.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get();
		log.info("Most experienced person is: {}", mostExperienced);

		Predicate<Employee> predicate4 = a -> a.getDepartment().equals("Sales And Marketing");
		Map<String, Long> result5 = listOfEmp.stream().filter(predicate4)
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		for (Map.Entry e : result5.entrySet()) {
			log.info("Count of the {} employess in Sales And Marketing department is: {}", e.getKey(), e.getValue());
		}

		Map<String, Double> result6 = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		for (Map.Entry e : result6.entrySet()) {
			log.info("Average salary of the {} employess is: {}", e.getKey(), e.getValue());
		}

		Map<String, List<Employee>> result7 = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		for (Map.Entry<String, List<Employee>> e : result7.entrySet()) {
			log.info("Names of the employess from department {} is: {}", e.getKey(),
					e.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
		}

		Double totalSal = listOfEmp.stream().map(Employee::getSalary).reduce((a, b) -> a + b).get();
		log.info("Total salary of emp is: {}", totalSal);

		Double avgSal = listOfEmp.stream().map(Employee::getSalary).reduce((a, b) -> a + b).get() / listOfEmp.size();
		log.info("Avg salary of emp is: {}", avgSal);

		DoubleSummaryStatistics empDoubleSummaryStatistics = listOfEmp.stream().mapToDouble(Employee::getSalary)
				.summaryStatistics();
		log.info("Avg salary of all employes using summary Statistics is: {}", empDoubleSummaryStatistics.getAverage());
		log.info("Total salary of all employes using summary Statistics is: {}", empDoubleSummaryStatistics.getSum());
		Predicate<Employee> predicate5 = a -> a.getAge() > 25;
		Map<Boolean, List<Employee>> result8 = listOfEmp.stream().collect(Collectors.partitioningBy(predicate5));
		for (Map.Entry<Boolean, List<Employee>> e : result8.entrySet()) {
			if (e.getKey().booleanValue()) {
				log.info("The youngest employes are {}",
						e.getValue().stream().map(Employee::getName).collect(Collectors.toList()));

			} else {
				log.info("The youngest employes are {}",
						e.getValue().stream().map(Employee::getName).collect(Collectors.toList()));

			}
		}

		listOfEmp.stream().max(Comparator.comparing(Employee::getAge)).ifPresent(a -> {
			System.out.println("His age is: " + a.getAge());
			System.out.println("His Department is: " + a.getDepartment());
		});

	}

	public static List<Employee> generateEmpData() {

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		employeeList.add(new Employee(288, "Sai Koushik", 26, "Male", "Product Development", 2018, 35700.0));
		employeeList.add(new Employee(299, "Lakshmi Soujanya", 25, "Female", "Product Development", 2019, 28900.0));
		employeeList.add(new Employee(300, "Ramarao", 52, "Male", "Sales And Marketing", 2012, 28900.0));
		employeeList.add(new Employee(310, "Sujatha", 48, "Female", "Product Development", 2016, 28900.0));
		return employeeList;
	}

}

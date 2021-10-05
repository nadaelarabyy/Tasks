import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("SE","Sam","XXXXXX"));
        employees.add(new Employee("SE","Nancy","YYYYYY"));
        employees.add(new Employee("ASE","Mark","ZZZZZZ"));
        Map<String, List<Employee>> EmployeesMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getTitle, HashMap::new, toList()));
        for(String key: EmployeesMap.keySet()){
            List<Employee> emp = EmployeesMap.get(key);
            if(emp.size()>=2)
                System.out.println("Title "+key+" Count "+emp.size());
            else
                System.out.println("Special title "+key);
            for(Employee e:emp)
                System.out.println(e.toString());

        }

    }
}

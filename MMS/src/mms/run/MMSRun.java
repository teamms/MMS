package mms.run;


import mms.database.initialConfig.JdbcDaoImplCreateTables;
import mms.model.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MMSRun {

	public static void main(String[] args) {
ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		
		JdbcDaoImplCreateTables dao=ctx.getBean("jdbcDaoImplCreateTables",JdbcDaoImplCreateTables.class);
		//dao.createPersonTable();
		Person person=new Person();
		dao.addPersonEntry(person);
		//Circle circle=(Circle)dao.getCircle(1);
		//System.out.println(circle.getName());
		//System.out.println(dao.getCircleCount());
		//System.out.println(dao.getCircleForId(2).getName());
		//System.out.println(dao.getAllCircles().size());
		//dao.insertCircle(new Circle(5,"fifth circle"));
		//dao.createTriangleTable();

	}

}

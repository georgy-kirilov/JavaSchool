package lists;

import coolcollections.CoolArrayList;
import coolcollections.CoolList;

public class QueryableDemo
{
	public static void main(String[] args)
	{
		CoolList<Car> cars = new CoolArrayList<>();
		
		cars.add(new Car("CA4536PH", 150000, 4, true));
		cars.add(new Car("RU9936PH", 2000, 2, false));
		cars.add(new Car("PK4536KK", 35000000, 4, true));
		cars.add(new Car("PL4500TT", 8000, 4, false));
		
		String result = cars
			.where(car -> !car.isOld)
			.sortBy(car -> car.kilometers)
			.each(car -> car.seats += 2)
			.select(car -> car.code.substring(2, 6) + " -> " + car.seats)
			.join("\n");
			
		System.out.println(result);
	}
}

package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.Test;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import engine.Distance;
import engine.Game;
import engine.Player;
import exceptions.FriendlyFireException;
import exceptions.MaxCapacityException;
import exceptions.BuildingInCoolDownException;
import exceptions.EmpireException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.MaxLevelException;
import exceptions.UnitFullCapacityException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Doctor;
import units.Infantry;
import units.Status;
import units.Unit;

@SuppressWarnings({ "rawtypes", "unchecked","unused" })
public class Q2V4 {
	String doctorPath = "units.Doctor";
	String unitPath = "units.Unit";
	@Test(timeout = 100)
	public void testHealMethodExists() {
		Method[] methods = Doctor.class.getDeclaredMethods();
		
		assertTrue("Class Doctor should contain a method named heal.", containsMethodName(methods, "heal"));
	}
	
	
	@Test(timeout = 1000)
	public void testHealMethodLogic(){
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(1,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(20);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		//healedUnit.setCurrentSoldierCount((int) (healedUnit.getMaxSoldierCount()*0.2));
		int currentSoldierCountAfter = healedUnit.getCurrentSoldierCount()+ (int) (healedUnit.getMaxSoldierCount()*0.2);
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	
	@Test(timeout = 1000)
	public void testHealMethodLogicLvl2(){
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(2,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(20);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		//healedUnit.setCurrentSoldierCount((int) (healedUnit.getMaxSoldierCount()*0.2));
		int currentSoldierCountAfter = healedUnit.getCurrentSoldierCount()+ (int) (healedUnit.getMaxSoldierCount()*0.3);
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	
	@Test(timeout = 1000)
	public void testHealMethodLogicLvl3(){
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(3,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(20);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		//healedUnit.setCurrentSoldierCount((int) (healedUnit.getMaxSoldierCount()*0.2));
		int currentSoldierCountAfter = healedUnit.getCurrentSoldierCount()+ (int) (healedUnit.getMaxSoldierCount()*0.4);
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	@Test(timeout = 1000)
	public void testHealMethodLogicCloseToMaxHP(){
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(1,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(50);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		//healedUnit.setCurrentSoldierCount((int) (healedUnit.getMaxSoldierCount()*0.2));
		int currentSoldierCountAfter = healedUnit.getMaxSoldierCount();
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	
	@Test(timeout = 1000)
	public void testHealMethodLogicCloseToMaxHPLVL2(){
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(2,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(42);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		//healedUnit.setCurrentSoldierCount((int) (healedUnit.getMaxSoldierCount()*0.2));
		int currentSoldierCountAfter = healedUnit.getMaxSoldierCount();
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	
	@Test(timeout = 1000)
	public void testHealMethodLogicCloseToMaxHPLVL3(){
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(3,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(36);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		//healedUnit.setCurrentSoldierCount((int) (healedUnit.getMaxSoldierCount()*0.2));
		int currentSoldierCountAfter = healedUnit.getMaxSoldierCount();
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	@Test(timeout = 1000, expected = UnitFullCapacityException.class)
	public void testHealMethodLogicWithMaxSoldierCount() throws Throwable{
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(1,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(60);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		//healedUnit.setCurrentSoldierCount((int) (healedUnit.getMaxSoldierCount()*0.2));
		int currentSoldierCountAfter = healedUnit.getMaxSoldierCount();
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (InvocationTargetException e) {
			if(e.getCause() instanceof UnitFullCapacityException){
				throw e.getCause();
				
			}else{
				throw e;
			}
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	
	
	@Test(timeout = 1000)
	public void testHealMethodLogicWithDeadUnit(){
		Unit healedUnit = new Archer(1,60,0.2,0.3,0.4);
		Unit healer = new Doctor(3,2,0.3,0.2,0.5);
		healedUnit.setCurrentSoldierCount(0);
		int currentSoldierCountBefore = healedUnit.getCurrentSoldierCount();
		int currentSoldierCountAfter = 0;
		try {

			Method m = Doctor.class.getDeclaredMethod("heal",Unit.class);
			m.invoke(healer,healedUnit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Healed Unit Current Soldier Count should be "+currentSoldierCountAfter+" but was " + healedUnit.getCurrentSoldierCount(),
				healedUnit.getCurrentSoldierCount(), currentSoldierCountAfter);
	}
	@Test(timeout = 100)
	public void testConstructorDoctorConstructor()
			throws Exception {
		Class[] inputs = { int.class, int.class, double.class, double.class, double.class };
		testConstructorExists(Class.forName(doctorPath), inputs);
		testClassIsSubclass(Class.forName(doctorPath), Class.forName(unitPath));
		
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	private void testConstructorInitialization(Object createdObject, String[] names, Object[] values)
			throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException {

		for (int i = 0; i < names.length; i++) {

			Field f = null;
			Class curr = createdObject.getClass();
			String currName = names[i];
			Object currValue = values[i];

			while (f == null) {

				if (curr == Object.class)
					fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
							+ currName + "\".");
				try {
					f = curr.getDeclaredField(currName);
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}

			}

			f.setAccessible(true);

			assertEquals(
					"The constructor of the " + createdObject.getClass().getSimpleName()
							+ " class should initialize the instance variable \"" + currName + "\" correctly.",
					currValue, f.get(createdObject));

		}

	}
	private void testConstructorExists(Class aClass, Class[] inputs) {
		boolean thrown = false;
		try {
			aClass.getConstructor(inputs);
		} catch (NoSuchMethodException e) {
			thrown = true;
		}

		if (inputs.length > 0) {
			String msg = "";
			int i = 0;
			do {
				msg += inputs[i].getSimpleName() + " and ";
				i++;
			} while (i < inputs.length);

			msg = msg.substring(0, msg.length() - 4);

			assertFalse(
					"Missing constructor with " + msg + " parameter" + (inputs.length > 1 ? "s" : "") + " in "
							+ aClass.getSimpleName() + " class.",

					thrown);
		} else
			assertFalse("Missing constructor with zero parameters in " + aClass.getSimpleName() + " class.",

					thrown);

	}
	private void testClassIsSubclass(Class subClass, Class superClass) {
		assertEquals(subClass.getSimpleName() + " class should be a subclass from " + superClass.getSimpleName() + ".",
				superClass, subClass.getSuperclass());
	}
	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}
}

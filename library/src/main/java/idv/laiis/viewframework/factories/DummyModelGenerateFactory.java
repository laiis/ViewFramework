package idv.laiis.viewframework.factories;

import java.util.HashMap;
import java.util.Map;

public final class DummyModelGenerateFactory {

	private DummyModelGenerateFactory(){
		
	}
	
//	public final static AbstractBaseModel newInstance(Class<?> cls,Map<String,Object> mapArgs){
//		try {
//			AbstractBaseModel baseModel=(AbstractBaseModel) cls.newInstance();
//			
//			Field[] fields=cls.getFields();
//			for(Field field:fields){
//				Object value=mapArgs.get(field.getName());
//				if(value!=null){
//					field.set(baseModel, value);	
//				}
//			}
//			
//			return baseModel;
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
	public final static Map<String,Object> getDummyDataMap(Object[][] objArr){
		Map<String,Object> map=new HashMap<String,Object>();
		for(Object[] obj:objArr){
			map.put(obj[0].toString(),obj[1]);
		}
		return map;
	}
}

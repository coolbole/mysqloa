package com.smb.framework.web.action;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.TreeMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
 

public class ObjectFactory {
 
	public static  synchronized Object getObjectFactory (Class<?> clazz , HttpServletRequest  request  ) throws Exception{
		 	Map<String, Object> map = new TreeMap<String, Object>();    
			Enumeration<?> names = request.getParameterNames();    
			while (names.hasMoreElements())    {      
				String name = (String) names.nextElement();    
				map.put(name,request.getParameterValues(name)[0] );    
			}
  
		  Object newobj=clazz.newInstance();
		  
		    Field Fields[]=clazz.getDeclaredFields();
		   for (int i=0;i<Fields.length;i++){
		          	String setMethodName = "set" + Fields[i].getName().substring(0,1).toUpperCase()+Fields[i].getName().substring(1) ;      
		            Method setMethod = clazz.getMethod(setMethodName, new Class[]{ Fields[i].getType() });
		         
		            Object oo=getCompatibleValue(map.get(Fields[i].getName() ),  Fields[i].getType() );
		            setMethod.invoke(newobj,  oo );  
		   }
		   return newobj;
 	}
 
 
 
	private static synchronized Object getCompatibleValue(Object value, Class<?> type) throws ParseException {
		  Object desValue=null;
		  	if (type.equals(int.class ) || type.equals(Integer.class )   ) {
		  		if (value!=null){desValue=new Integer( value.toString()  ); }
		  		else{ desValue=0;  }
		  }
		  else  if (
		    type.equals(Date.class ) || type.equals(Date.class )   ) {
			  if (value!=null){
			      if (value.toString().indexOf(":")!=-1 ){
			      DateFormat FORMAT_DT_yyyy_MM_dd__HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			      desValue=FORMAT_DT_yyyy_MM_dd__HH_mm_ss.parse( value.toString() );
			     }
			     else{
			      DateFormat FORMAT_DT_yyyy_MM_dd__HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd");  
			      desValue=FORMAT_DT_yyyy_MM_dd__HH_mm_ss.parse( value.toString() );
			     }
		   }
		    else{ desValue= null ;  }
		  }
		  else if (
			    type.equals(Double.class ) || type.equals(double.class )   ) {
			    if (value!=null){   desValue=new Double( value.toString()  ); }
			    else{ desValue=new Double( "0" );  }
		  }
		  else if (
		      type.equals(Long.TYPE) || type.equals(long.class )   ) {
		      if (value!=null){ desValue=new Long( value.toString()  );    }
		      else{ desValue=0;  }
		    }
		    else if (
		      type.equals(Float.TYPE)  || type.equals(float.class )  ) {
		      if (value!=null){desValue=new Float( value.toString()  );}
		      else{ desValue=0;  }
		    }
		    else if (
		      type.equals(Short.TYPE) || type.equals(short.class )  ) {
		      if (value!=null){desValue=new Short( value.toString()  );}
		      else{ desValue=0;  }
		    }
		    else if (
		      type.equals(Byte.TYPE) || type.equals(byte.class ) ) {
		      if (value!=null){desValue=new Byte( value.toString()  );}
		      else{ desValue=0;  }
		    }
		   else if (
	    		type.equals(Boolean.TYPE)  ||  type.equals(boolean.class )) {
	    		if (value!=null){desValue=new Boolean( value.toString()  );}
	    		else{ desValue=true;  }
		    }
		    else{
		       desValue=value;
		    }
		        return desValue;
		}
 }

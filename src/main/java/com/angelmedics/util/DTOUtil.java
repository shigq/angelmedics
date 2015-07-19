package com.angelmedics.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class DTOUtil {

	public static void CopyProperties(Object src, Object to) {
		Field[] toFields = to.getClass().getDeclaredFields();
		Field[] srcFields = src.getClass().getDeclaredFields();
		for (Field toField : toFields) {
			// 不拷贝static成员和final成员
			if (Modifier.isStatic(toField.getModifiers())
					|| Modifier.isFinal(toField.getModifiers())) {
				continue;
			}

			boolean blnFind = false;
			for (int s = 0; s < srcFields.length; s++) {
				if (srcFields[s].getName().equals(toField.getName())) {
					blnFind = true;
					break;
				}
			}
			if (!blnFind) {
				continue;
			}
			try {
				Field srcField = src.getClass().getDeclaredField(
						toField.getName());
				toField.setAccessible(true);
				srcField.setAccessible(true);

				toField.set(to, srcField.get(src));
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}

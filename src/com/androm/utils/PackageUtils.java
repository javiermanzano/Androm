package com.androm.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class PackageUtils {

	private PackageUtils() { }

	/**
	 * Get the classes from a packages list
	 * @param packagesNames
	 * @return
	 */
	public static List<Class<?>> getClasses(String... packagesNames) {
		List<Class<?>> classes = Lists.newArrayList();
		for (String packageName : packagesNames) {
			classes.addAll(getClasses(packageName));
		}
		return classes;
	}
	

	/**
	 * Get the classes from a package
	 * @param packageName Package to be explored
	 * @return Classes in the package
	 */
	public static List<Class<?>> getClasses(String packageName) {
		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			if (classLoader == null) {
				throw new RuntimeException(
						"Class loader could not be retrieved");
			}
			String path = packageName.replace('.', '/');

			List<File> dirs = Lists.newArrayList();
			ArrayList<URL> resources = Lists.newArrayList(Iterators
					.forEnumeration(classLoader.getResources(path)));
			for (URL resource : resources) {
				dirs.add(new File(resource.getFile()));
			}

			ArrayList<Class<?>> classesFound = Lists.newArrayList();
			for (File directory : dirs) {
				classesFound.addAll(findClasses(directory, packageName));
			}

			return classesFound;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Find classes recursively
	 * @param directory
	 * @param packageName
	 * @return
	 */
	private static List<Class<?>> findClasses(File directory, String packageName) {
		try {
			List<Class<?>> classes = Lists.newArrayList();
			if (!directory.exists()) {
				return classes;
			}
			File[] files = directory.listFiles();
			for (File file : files) {
				if (file.isDirectory() && !file.getName().contains(".")) {
					classes.addAll(findClasses(file,
							packageName + "." + file.getName()));
				} else if (file.getName().contains(".class")) {
					classes.add(Class.forName(packageName
							+ "."
							+ file.getName().substring(0,
									file.getName().length() - 6)));
				}
			}

			return classes;

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

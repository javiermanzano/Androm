package com.androm.table;

public enum ColumnModifier {

	NOT_NULL {
		@Override
		public String getModifierName() {
			return "NOT NULL";
		}

	},
	PRIMARY_KEY {
		@Override
		public String getModifierName() {
			return "PRIMARY KEY";
		}

	}, 
	
	// TODO DEFAULT hay que pasarle un valor por defecto
	DEFAULT {
		
		@Override
		public String getModifierName() {
			return "";
		}
	}
	;

	private String name;
	
	private String value;

	public abstract String getModifierName();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

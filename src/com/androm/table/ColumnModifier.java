package com.androm.table;

public enum ColumnModifier {

	NOT_NULL {
		@Override
		public String modifierName() {
			return "not null";
		}

	},
	PRIMARY_KEY {
		@Override
		public String modifierName() {
			return "primary key";
		}

	}, 
	
	DEFAULT {

		@Override
		public String modifierName() {
			return "default";
		}
	}
	;

	private String name;

	public abstract String modifierName();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

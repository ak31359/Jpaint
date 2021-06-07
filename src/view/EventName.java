package view;

public enum EventName {
	SHAPE_CHOOSE_EVENT{
		@Override
		public String toString() {
			return "CHOOSE SHAPE";
		}
	},
	PRIMARY_COLOR_CHOOSE_EVENT {
		@Override
		public String toString() {
			return "CHOOSE PRIMARY COLOR";
		}
	},
	SECONDARY_COLOR_CHOOSE_EVENT {
		@Override
		public String toString() {
			return "CHOOSE SECONDARY COLOR";
		}
	},
	SHADING_TYPE_CHOOSE_EVENT {
		@Override
		public String toString() {
			return "CHOOSE SHADING TYPE";
		}
	},
	MOUSE_MODE_CHOOSE_EVENT {
		@Override
		public String toString() {
			return "CHOOSE MOUSE MODE";
		}
	},
	UNDO,
	REDO,
	COPY,
	PASTE,
	DELETE
}


public class Student {
	

		private String firstName, lastName, id;
		private boolean tuitionPaid;

		public Student(String firstName, String lastName, String id, boolean tuitionPaid) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
			this.tuitionPaid = tuitionPaid;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getID() {
			return id;
		}

		public void setID(String id) {
			this.id = id;
		}

		public boolean isTuitionPaid() {
			return tuitionPaid;
		}

		public void setTuitionPaid(boolean tuitionPaid) {
			this.tuitionPaid = tuitionPaid;
		}

		@Override
		public String toString() {
			return firstName + " " + lastName + " (" + id + ")";
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Student) {
				Student anotherStudent = (Student) obj;
				boolean sameFirstName, sameLastName, sameId,sameTuitionPaid;
				if (this.firstName.equalsIgnoreCase(anotherStudent.firstName)) {
					sameFirstName=true;
				}else {
					sameFirstName=false;
				}
				if(this.lastName.equalsIgnoreCase(anotherStudent.lastName)) {
					sameLastName=true;
				}else {
					sameLastName=false;
				}
				if(this.id.equalsIgnoreCase(anotherStudent.id)) {
					sameId=true;
				}else {
					sameId=false;
				}
				if(this.tuitionPaid==anotherStudent.tuitionPaid) {
					sameTuitionPaid = true;
				}else {
					sameTuitionPaid = false;
				}
				return sameFirstName&& sameLastName && sameId && sameTuitionPaid;
			}else {
				return false;
			}
		}
	


}

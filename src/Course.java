
public class Course {
	private String course;
	private Student []roster; 
	private Student[]waitList;
	private int maxNumberRoster, maxNumberWaitList;
	
	
	
	public Course(String course,int maxNumberRoster,int maxNumberWaitList) {
		this.course = course;
		this.maxNumberRoster= maxNumberRoster;
		this.maxNumberWaitList = maxNumberWaitList;
		roster= new Student[maxNumberRoster];
		waitList=new Student[maxNumberWaitList];
	}
	
	public String getCourse() {
		return course;
	}
	public Student[] getRoster(){
		return roster;
	}
	public Student[] getWaitList() {
		return waitList;
	}
	public void setCourse(String course) {
		this.course=course;
	}
	public void setMaxNumberRoster(int maxNumberRoster) {
		if(maxNumberRoster>0) {
			this.maxNumberRoster = maxNumberRoster;
		}
	}
	public void setMaxNumberWaitList(int maxNumberWastList) {
		if(maxNumberWaitList>0) {
			this.maxNumberWaitList= maxNumberWaitList;
		}
	}
	@Override
	public String toString() {
		int numRegisted=0, numWaitList=0;
		for (int i=0;i<roster.length;i++) {
			if(roster[i]!=null) {
				numRegisted++;		
			}
		}
		System.out.println(numRegisted + " enrolled (maximum allowed "+ maxNumberRoster+")");
		for(int i=0; i<roster.length;i++) {
			if(roster[i]!=null) {
				System.out.println("\t"+roster[i]);
			}
			
		}
		for (int i=0; i<waitList.length;i++) {
			if(waitList[i]!=null) {
				numWaitList++;	
			}
			
		}
		System.out.println(numWaitList + " on waitlist (maximum allowed "+ maxNumberRoster+")");
		for (int i=0; i<waitList.length;i++) {
			if(waitList[i]!=null) {
				System.out.println("\t"+waitList[i]);
			}
			
		}
		return "";
	}//end toString
	
	public boolean addStudent(Student student) {
		for(int i=0; i<roster.length;i++) {
			if (student.isTuitionPaid()&& (!student.equals(roster[i]))) {
				if(roster[i]==null) {
					roster[i]=student;
					return true;
				}
				
			}
		}
		for(int i=0; i<waitList.length;i++) {
			if(student.isTuitionPaid()&& (!student.equals(waitList[i]))) {
				if(waitList[i]==null) {
					waitList[i]=student;
					return true;
					
				}
				
			}
		}
		return false;
	}
	
	public boolean dropStudent (Student student) {
		for (int i =0; i<roster.length;i++) {
			if(student.equals(roster[i])) {
				roster[i]=null;
				if(waitList[i]!=null) {
					roster[i]= waitList[0];
					waitList[0]=null;
				}
				return true;
				
			}
		}
		for (int i=0;i<waitList.length;i++) {
			if(student.equals(waitList[i])) {
				waitList[i]=null;
				return true;
			}
		}
		return false;
	}
	

}//end course class

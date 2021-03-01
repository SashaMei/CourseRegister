import java.util.ArrayList;

public class CourseAL {
	private String course;
	private ArrayList<Student> rosterList; 
	private ArrayList<Student> waitList;
	private int maxNumberRoster, maxNumberWaitList;

	public CourseAL(String course,int maxNumberRoster,int maxNumberWaitList) {
		this.course = course;
		this.maxNumberRoster= maxNumberRoster;
		this.maxNumberWaitList = maxNumberWaitList;
		rosterList= new ArrayList<Student>();
		waitList=new ArrayList<Student>();
	}
	
	public String getCourse() {
		return course;
	}
	public ArrayList<Student> getRosterList(){
		return rosterList;
	}
	public ArrayList<Student> getWaitList() {
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
		for (int i=0;i<rosterList.size();i++) {
			if(rosterList.get(i)!=null) {
				numRegisted++;		
			}
		}
		System.out.println(numRegisted + " enrolled (maximum allowed "+ maxNumberRoster+")");
		for(int i=0; i<rosterList.size();i++) {
			if(rosterList.get(i)!=null) {
				System.out.println("\t"+rosterList.get(i));
			}
			
		}
		for (int i=0; i<waitList.size();i++) {
			if(waitList.get(i)!=null) {
				numWaitList++;	
			}
			
		}
		System.out.println(numWaitList + " on waitlist (maximum allowed "+ maxNumberRoster+")");
		for (int i=0; i<waitList.size();i++) {
			if(waitList.get(i)!=null) {
				System.out.println("\t"+waitList.get(i));
			}
			
		}
		return "";
	}//end toString

	
	public boolean addStudent(Student student) {
		if ((student.isTuitionPaid()) && ((!rosterList.contains(student)) || (!waitList.contains(student)))) {
			if (rosterList.size() < maxNumberRoster) {
				return rosterList.add(student);
			} else if (waitList.size() < maxNumberWaitList) {
				return waitList.add(student);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean dropStudent(Student student) {
		if (rosterList.contains(student)) {
			rosterList.remove(student);
			if (waitList.size() > 0) {
				rosterList.add(waitList.get(0));
				waitList.remove(0);
			}
			return true;
		}
		if (waitList.contains(student)) {
			waitList.remove(student);
			return true;
		}
		return false;
	}
}//end courseAL class

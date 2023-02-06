package utill;

public class Paging {
	
	int page = 1; //현재 페이지
	int totalPage; //전체 페이지
	int total; //전체 레코드 수(총 게시글 수)
	int start; //페이지마다 표시할 게시물 시작 번호
	int end; //페이지마다 표시할 게시물 끝 번호
	int showRow = 5; //한 페이지에 표시할 게시글 수
	int showNum = 10; // 한 화면에 표시되는 페이지번호 개수
	
	//전체페이지와 해당 페이지에 표시할 시작, 끝번호를 계산해주는 메서드
	//전에 현재페이지는 설정되어있어야 함
	public void pageCalc(int total) {
		this.total = total;
		
		totalPage = (int)Math.ceil((double)total / showRow);
		
		start = (page - 1) * showRow + 1;
		end = start + showRow - 1;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getShowRow() {
		return showRow;
	}

	public void setShowRow(int showRow) {
		this.showRow = showRow;
	}

	public int getShowNum() {
		return showNum;
	}

	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}
	
	
}

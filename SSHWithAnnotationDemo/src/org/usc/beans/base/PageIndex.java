package org.usc.beans.base;

public class PageIndex {
	private int startIndex;
	private int endIndex;
	
	public PageIndex(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	 
	public static PageIndex getPageIndex(int viewPageCount, int currentPage, int totalpage){
			int startpage = currentPage-(viewPageCount%2==0? viewPageCount/2-1 : viewPageCount/2);
			int endpage = currentPage+viewPageCount/2;
			if(startpage<1){
				startpage = 1;
				if(totalpage>=viewPageCount) endpage = viewPageCount;
				else endpage = totalpage;
			}
			if(endpage>totalpage){
				endpage = totalpage;
				if((endpage-viewPageCount)>0) startpage = endpage-viewPageCount+1;
				else startpage = 1;
			}
			return new PageIndex(startpage, endpage);		
	}
}

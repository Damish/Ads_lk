package com.damishs.ads_lk.ui.category;

public class CategoryItem {

    private String categoryName;
    private String noOfResults;

    public CategoryItem(String categoryName, String noOfResults) {
        this.categoryName = categoryName;
        this.noOfResults = noOfResults;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getNoOfResults() {
        return noOfResults;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setNoOfResults(String noOfResults) {
        this.noOfResults = noOfResults;
    }
}

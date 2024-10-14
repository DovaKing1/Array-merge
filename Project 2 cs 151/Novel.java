/**
 * @author Elijah McCray
 * @author Anna Sloan
 */


public class Novel{
    //FIELDS
    public String title;
    public String author;
    public String genre;
    public int date;

    /**
     * Constructs a new Novel object with the specified title, author, genre, and publication date.
     * 
     * @param title the title of the novel
     * @param author the author of the novel
     * @param genre the genre of the novel
     * @param date the publication date of the novel
     */
    public Novel(String title, String author, String genre, int date){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.date = date;
    }



    // Get methods.
    public String getTitle(){
        return this.title;
    }    
    public String getAuthor(){
        return this.title;
    }
    public String getGenre(){
        return this.genre;
    }
    public int getDate(){
        return this.date;
    }



    // Set Methods.
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setDate(int date){
        this.date = date;
    }


    /**
     * Compares this Novel object to the specified object for equality.
     * 
     * @param other the object to be compared for equality with this Novel object
     * @return true if the specified object is equal to this Novel object, false otherwise
     */
    @Override
    public boolean equals(Object other){
        boolean equal = (other == this);
        Novel book = (Novel)other;
        if (!equal && book instanceof Novel){
            if (this.getTitle() == book.getTitle()){
                if (this.getAuthor() == book.getAuthor()){
                    if (this.getGenre() == book.getGenre()){
                        if (this.getDate() == book.getDate()){
                            equal = true;
                        }
                    }
                }
            }
        }
        return equal;
    }

    /**
     * Returns a string representation of the Novel object.
     * 
     * @return a string representation of the Novel object   
    */
    public String toString(){
        return this.title + " : " + this.author + " : " + this.genre + " : " + this.date + ".";
    }


}


public class Book_6 {

	

		private String title;
		private int num_pages;
		private double price;
		private int quantity;

	
		// Constructor: Takes in the title of the book, the number of pages in the book, the cost of the 
		// the book and the quantity of books and initializes each of the appropriate instances variables
		// in the object.
		public Book_6(String thetitle, int pages, double cost, int num){
			this.title = thetitle;
			this.num_pages = pages;
			this.price = cost;
			this.quantity = num;

	
		}
		
		// This method executes selling num number of books. If num is negative, zero, or larger than the 
		//  quantity stored in the book object, return 0. Otherwise, adjust the quantity instance variable of
		//  the object to indicate selling num books and return the total price of the books sold.
		public double sell(int num){
			if(num <= 0 || num > this.quantity){
				return 0;
			}
			else{
				this.quantity = num;
			}
			
			
			return this.price * num;
		}
		// Returns all the information about a Book object in a String. (Make it readable!)
		public String toString(Book_6 book){
		
			String book_info = "";
			book_info = "Title : " + book.title + "\nNumber of Pages: " + book.num_pages + "\nPrice: $" + book.price + "\nNumber of books: " + book.quantity + "\n";
			//System.out.println(book_info);
			
			return book_info;
		}
		// If the Book Object this method is called on has more than 300 pages, this method will create a 
		// new Book object. This new book object will have 1/6 the total number of pages, 1/2 the price 
		// and the same quantity as the object upon which the method was called. Finally, the title of the 
		// new book object will be the old title with "cliff" concatenated to the front of it. If the Book 
		// object this method is called on has 300 pages or less, null should be returned.
		public Book_6 cliff_notes(Book_6 book){
			
			if(book.num_pages > 300){
				Book_6 book2 = new Book_6(("cliff" + book.title), (book.num_pages / 6), (book.price / 2), book.quantity);
				return book2;
			}
			else{
				return null;
			}

		}
		// Returns the title of the Book object the method is called on.
		public String get_title(Book_6 book){
			return book.title;
		}
		// Adds change number of books to the Book object. If change is negative, nothing is done. 
		public void add_quantity(int change, Book_6 book){
			if(change >=0){
				book.quantity += change;
			}
		}

		// Returns the quantity of the Book object.
		public int get_quantity(Book_6 book){
			return book.quantity;
		}

		// Returns the price of the Book object.
		public double get_price(Book_6 book){
			return book.price;
		}


	
	public static void main(String[] args) {
	
		
		Book_6 book = new Book_6("Whinnie the Pooh", 400, 5.95, 10);
		book.toString();
		
		System.out.println(book.toString(book));
		book.add_quantity(6, book);
		System.out.println(book.toString(book));
		book = book.cliff_notes(book);
		System.out.println(book.toString(book));
		
	}

}

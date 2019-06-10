
/**
 * Tree Node for AVL tree
 * 
 * @author Huiping Cao
 *
 */
class AVLNode {
	private int data; // the element value for this node
	private AVL left; // the left child of this node
	private AVL right; // the right child of this node
	private int height; // height of the tree rooted at this node

	public AVLNode() {
		data = 0;
		left = new AVL();
		right = new AVL();
		height = 0;
	}

	public AVLNode(int initData) {
		data = initData;
		left = new AVL();
		right = new AVL();
		height = 0;
	}

	/**
	 * Constructor with the initial element, initial left and right children
	 * 
	 * @param initData: the initial element
	 * @param initLeft: left child
	 * @param initRight: right child
	 */
	public AVLNode(int initData, AVL initLeft, AVL initRight) {
		data = initData;
		left = initLeft;
		right = initRight;
		height = 1;
	}

	public int getData() {
		return data;
	}

	public AVL getLeft() {
		return left;
	}

	public AVL getRight() {
		return right;
	}

	public int getHeight() {
		return height;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(AVL left) {
		this.left = left;
	}

	public void setRight(AVL right) {
		this.right = right;
	}

	/**
	 * Set the height of the tree rooted at this node
	 */
	public void setHeight() {
		this.height = 1 + Math.max(getLeftHeight(), getRightHeight());
	}

	/**
	 * Convert this BTNode to a string
	 */
	public String toString() {
		String str = "";
		if (left == null)
			str += "(null)";
		else
			str += "(" + left.getRoot().getData() + ")";

		str += data;

		if (right == null)
			str += "(null)";
		else
			str += "(" + right.getRoot().getData() + ")";

		return str;
	}

	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	// Rebalancing related methods

	/**
	 * Get the height of the left subtree
	 */
	public int getLeftHeight() {
		if (left == null || left.getRoot() == null)
			return 0;
		else
			return left.getRoot().getHeight();
	}

	/**
	 * Get the height of the right subtree
	 * 
	 * @return: the height of the right sub-tree
	 */
	public int getRightHeight() {
		if (right == null || right.getRoot() == null)
			return 0;
		else
			return right.getRoot().getHeight();
	}

}

public class AVL {
	private AVLNode root; // instance variable to denote the root of the AVL tree

	// Constructors for the AVL tree
	public AVL() {
		root = null;
	}

	public AVL(int e) {
		root = new AVLNode(e, new AVL(), new AVL());
	}

	// Basic set and get methods
	public AVLNode getRoot() {
		return root;
	}

	public void setRoot(AVLNode _root) {
		this.root = _root;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	private AVL getLeftSubtree() {
		return root.getLeft();
	}

	private AVL getRightSubtree() {
		return root.getRight();
	}

	private void setHeight() {
		root.setHeight();
	}

	/**
	 * Check whether the tree (rooted at this node) is right heavy or not
	 * 
	 * @return
	 */
	private boolean rightHeavy() {
		return (root.getLeftHeight() < root.getRightHeight());
	}

	/**
	 * Check whether the tree (rooted at this node) is left heavy or not
	 * 
	 * @param node
	 * @return
	 */
	private boolean leftHeavy() {
		return (root.getLeftHeight() > root.getRightHeight());
	}

	/**
	 * Check whether the tree (rooted at this node) is right too heavy or not
	 * 
	 * @return
	 */
	private boolean rightTooHeavy() {
		return ((root.getLeftHeight() + 1) < root.getRightHeight());
	}

	/**
	 * Check whether the tree (rooted at this node) is left too heavy or not
	 * 
	 * @param node
	 * @return
	 */
	private boolean leftTooHeavy() {
		return (root.getLeftHeight() > (root.getRightHeight() + 1));
	}

	/**
	 * Traversal the tree in-order and print it
	 */
	public void inOrderTraversal() {
		inOrderTraversal(0);
	}

	/**
	 * Private function to print the tree with in-order traversal
	 * 
	 * @param indentation: the number of space before the data, to make the printing
	 *        more beautiful
	 */
	private void inOrderTraversal(int indentation) {
		if (root != null) {
			if (root.getRight() != null)
				root.getRight().inOrderTraversal(indentation + 1);
			for (int i = 0; i < indentation * 2; i++)
				System.out.print(" ");
			System.out.println(root.getData());
			if (root.getLeft() != null)
				root.getLeft().inOrderTraversal(indentation + 1);
		}
	}

	public String inOrderStr() {
		if (root != null)
			return (root.getLeft().inOrderStr() + " " + root.getData() + " " + root.getRight().inOrderStr());
		else
			return "";
	}

	/**
	 * Print the tree using pre-order traversal strategy recursively.
	 */
	public void preOrderPrtRecursive() {
		if (root == null)
			return;

		System.out.print(root.getData() + " ");
		this.getLeftSubtree().preOrderPrtRecursive();
		this.getRightSubtree().preOrderPrtRecursive();
	}

	public void rotateRight() {

		AVL b = new AVL();

		b.setRoot(getLeftSubtree().root);

		getLeftSubtree().setRoot(getLeftSubtree().getRightSubtree().root);

		b.getLeftSubtree().setRoot(this.root);

		this.setRoot(b.root);

		getLeftSubtree().setHeight();

		b.setHeight();

		b.getRightSubtree().setHeight();

		this.setHeight();

	}

	public void rotateLeft() {

		AVL b = new AVL();

		b.setRoot(getRightSubtree().root);

		getRightSubtree().setRoot(getRightSubtree().getLeftSubtree().root);

		b.getRightSubtree().setRoot(this.root);

		this.setRoot(b.root);

		getRightSubtree().setHeight();

		b.setHeight();

		b.getLeftSubtree().setHeight();

		this.setHeight();

	}

	public void rebalance() {

		if (root == null)
			return;

		if (leftTooHeavy()) {

			if (getLeftSubtree().rightHeavy())

				getLeftSubtree().rotateLeft();

			rotateRight();

		}

		if (rightTooHeavy()) {

			if (getRightSubtree().leftHeavy())

				getRightSubtree().rotateRight();

			rotateLeft();

		}

	}

	public void insert(int e) {

		if (root == null) {

			root = new AVLNode(e);

		}

		else if (e < root.getData()) {

			root.getLeft().insert(e);

			this.rebalance();

			this.setHeight();

		}

		else if (e > root.getData()) {

			root.getRight().insert(e);

			this.rebalance();

			this.setHeight();

		}

	}

	public AVLNode search(int e) {

		if (root == null)

			return null;

		if (root.getData() == e)

			return root;

		if (e > root.getData())

			return root.getRight().search(e);

		return root.getLeft().search(e);

	}

	public boolean remove(int e) {

		if (this.search(e) == null)

			return false;

		if (e < root.getData()) {

			this.root.getLeft().remove(e);

			rebalance();

		}

		if (e > root.getData()) {

			this.root.getLeft().remove(e);

			rebalance();
		}

		if (this.root.getData() == e) {

			try {

				if (this.root.getLeft().root == null && this.root.getRight().root == null) {

					this.root = null;

					return true;
				}

				if (this.root.getLeft().root == null && this.root.getRight().root != null) {

					this.root = root.getRight().root;

					return true;

				}

				if (this.root.getLeft().root != null && this.root.getRight().root == null) {

					this.root = root.getLeft().root;

					return true;

				}

				if (this.root.getLeft().root != null && this.root.getRight().root != null) {

					this.root.setData(root.getLeft().max().getData());

					rebalance();

					return true;

				}
			}

			catch (NullPointerException f) {
			}

		}

		return true;
	}

	public AVLNode max() {

		AVLNode maxData;

		if (root.getRight().root == null) {

			maxData = root;

			root = this.root.getLeft().root;

			return maxData;

		}

		return root.getRight().max();

	}

	public int countOccurrences(int e) {

		int count = 0;
		if (root != null) {

			if (root.getData() == e)
				count++;

			if (getLeftSubtree().root != null)

				count = count + getLeftSubtree().countOccurrences(e);

			if (getRightSubtree().root != null)

				count = count + getRightSubtree().countOccurrences(e);
		}

		return count;

	}

	public void preOrderPrtNonRecursive() {

		if (root == null)
			return;

		System.out.print(root.getData() + " ");

		while (root.getLeft().root != null && root.getRight().root != null) {

			while (getLeftSubtree().root != null) {

				root = getLeftSubtree().root;

				System.out.print(root.getData() + " ");

				if (getRightSubtree().root != null) {

					root = getRightSubtree().root;

					System.out.println(root.getData() + " ");
				}

			}

		}

	}

}

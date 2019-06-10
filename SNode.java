
public class SNode<E> {

	public SNode<E> node;

	public E data;

	public SNode() {

		node = null;

		data = null;

	}

	public void setNode(SNode<E> thing) {

		node = thing;

	}

	public SNode<E> getNode() {

		return node;

	}

	public E getData() {

		return data;

	}

	public void setData(E d) {

		data = d;
	}

}

package com.lansrod.test1.ws;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractResponse implements Serializable {

	private static final long serialVersionUID = 4758741729185517100L;

	private final String id;
	private final Long status;
	private final Object message;

	public AbstractResponse(Long status) {
		super();
		this.id = UUID.randomUUID().toString();
		this.status = status;
		this.message = null;
	}

	public AbstractResponse(Long status, Object message) {
		super();
		this.id = UUID.randomUUID().toString();
		this.status = status;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public Long getStatus() {
		return status;
	}

	public Object getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractResponse other = (AbstractResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractResponse [id=" + id + ", status=" + status + ", message=" + message + "]";
	}

}

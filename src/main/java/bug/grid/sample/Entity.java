package bug.grid.sample;





public class Entity  {
	public Entity(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Entity entity = (Entity) o;

		return id != null ? id.equals(entity.id) : entity.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}

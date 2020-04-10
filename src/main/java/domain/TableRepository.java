package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class TableRepository {
	private static final List<Table> tables = new ArrayList<>();
	private static final String NONE_EXIST_TABLE_WITH_NUMBER_EXCEPTION_MESSAGE = "해당 번호의 테이블이 존재하지 않습니다.";

	static {
		tables.add(new Table(1));
		tables.add(new Table(2));
		tables.add(new Table(3));
		tables.add(new Table(5));
		tables.add(new Table(6));
		tables.add(new Table(8));
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}

	public Table findTable(int tableId) {
		return tables.stream()
			.filter(table -> table.isSameNumber(tableId))
			.findFirst()
			.orElseThrow(() -> new NoSuchElementException(NONE_EXIST_TABLE_WITH_NUMBER_EXCEPTION_MESSAGE));
	}
}

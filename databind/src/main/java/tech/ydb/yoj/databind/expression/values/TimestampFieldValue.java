package tech.ydb.yoj.databind.expression.values;

import lombok.NonNull;
import tech.ydb.yoj.databind.FieldValueType;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Optional;

public record TimestampFieldValue(@NonNull Instant timestamp) implements FieldValue {
    @Override
    public Optional<Comparable<?>> getComparableByType(Type fieldType, FieldValueType valueType) {
        return switch (valueType) {
            case INTEGER -> Optional.of(timestamp.toEpochMilli());
            case TIMESTAMP -> Optional.of(timestamp);
            default -> Optional.empty();
        };
    }

    @Override
    public String toString() {
        return "#" + timestamp + "#";
    }
}
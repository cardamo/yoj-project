package tech.ydb.yoj.databind.expression.values;

import lombok.NonNull;
import tech.ydb.yoj.databind.FieldValueType;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public record UuidFieldValue(@NonNull UUID uuid) implements FieldValue {
    @Override
    public Optional<Comparable<?>> getComparableByType(Type fieldType, FieldValueType valueType) {
        if (Objects.requireNonNull(valueType) != FieldValueType.UUID) {
            return Optional.empty();
        }
        return Optional.of(uuid.toString());
    }

    @Override
    public String toString() {
        return uuid.toString();
    }
}
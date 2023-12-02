package com.example.a24.GsonHelper;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class OffsetDateTimeAdapter extends TypeAdapter<OffsetDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void write(JsonWriter out, OffsetDateTime value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            ZoneId utcZone = ZoneId.of("Europe/Moscow");
            OffsetDateTime utcValue = value.withOffsetSameInstant(utcZone.getRules().getOffset(value.toInstant()));
            out.value(formatter.format(utcValue));
        }
    }

    @Override
    public OffsetDateTime read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        } else {
            String stringValue = in.nextString();
            ZoneId utcZone = ZoneId.of("Europe/Moscow");
            return OffsetDateTime.parse(stringValue, formatter)
                    .withOffsetSameInstant(utcZone.getRules().getOffset(Instant.now()));
        }
    }
}

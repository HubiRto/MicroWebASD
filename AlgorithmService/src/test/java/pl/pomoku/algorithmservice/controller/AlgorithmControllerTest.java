package pl.pomoku.algorithmservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;
import pl.pomoku.algorithmservice.service.BinSearchService;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AlgorithmController.class)
public class AlgorithmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BinSearchService binSearchService;


    @Test
    public void algorithmControllerBinSearchReturnOk() throws Exception {
        BinSearchInput input = new BinSearchInput(new int[]{1, 3, 4, 5, 6, 7, 13, 15, 16, 17, 18}, 1);
        BinSearchOutput expectedOutput = new BinSearchOutput(List.of(0, 2, 5), 5, 0);

        given(binSearchService.getResult(input)).willReturn(expectedOutput);

        mockMvc.perform(post("/api/v1/algorithm/binary-search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.mArr").isArray())
                .andExpect(jsonPath("$.mArr[0]").value(expectedOutput.mArr().get(0)))
                .andExpect(jsonPath("$.mArr[1]").value(expectedOutput.mArr().get(1)))
                .andExpect(jsonPath("$.mArr[2]").value(expectedOutput.mArr().get(2)))
                .andExpect(jsonPath("$.comparisonsCount").value(expectedOutput.comparisonsCount()))
                .andExpect(jsonPath("$.result").value(expectedOutput.result()));

    }
}

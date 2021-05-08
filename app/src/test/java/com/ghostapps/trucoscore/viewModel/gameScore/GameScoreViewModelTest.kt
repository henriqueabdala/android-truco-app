package com.ghostapps.trucoscore.viewModel.gameScore

import com.ghostapps.trucoscore.domain.useCases.InsertRegister
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameScoreViewModelTest {

    private val gameScoreContractMock: GameScoreContract = mock {}
    private val insertRegisterMock: InsertRegister = mock {
        given { it.execute(any()) }.willReturn { true }
    }

    private lateinit var sut: GameScoreViewModel

    @Before
    fun setup() {
        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterMock)
    }

    @Test
    fun `Should update team names correctly`() {
        val teamAName = "team_a"
        val teamBName = "team_b"

        sut.onCreate(teamAName, teamBName)

        assertEquals(sut.homeTeamName, teamAName)
        assertEquals(sut.awayTeamName, teamBName)
    }

    @Test
    fun `Should increase home team score when onHomeTeamIncrease is called`() {
        sut.onHomeTeamIncrease()
        assertEquals(sut.formattedHomeTeamScore, "01")

        sut.onHomeTeamIncrease()
        assertEquals(sut.formattedHomeTeamScore, "02")
    }

//    @Test
//    fun `Should call onInsertRegisterFails when insertRegister fails`() {
//        val insertRegisterFailsMock: InsertRegister = mock {
//            given { it.execute(any()) }.willReturn { true }
//        }
//
//        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterFailsMock)
//
//        sut.onExitPressed()
//
//        verify(gameScoreContractMock, times(1)).onInsertRegisterFails()
//    }





}